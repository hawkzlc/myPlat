package com.yue.cas.ticket.redisRegistry;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

import org.jasig.cas.ticket.ServiceTicket;
import org.jasig.cas.ticket.Ticket;
import org.jasig.cas.ticket.TicketGrantingTicket;
import org.jasig.cas.ticket.registry.AbstractDistributedTicketRegistry;
import org.springframework.beans.factory.DisposableBean;

//import com.sun.istack.FinalArrayList;

import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

public final class RedisTicketRegistry extends AbstractDistributedTicketRegistry implements DisposableBean {

	/*
	 * Redis client
	 * 
	 * @see
	 * org.jasig.cas.ticket.registry.TicketRegistry#addTicket(org.jasig.cas.
	 * ticket.Ticket)
	 */
	private JedisSentinelPool jedisSentinelPool;
	private int st_time; // st最大空闲时间
	private int tgt_time; // tgt最大空闲时间

	@Override
	public void addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		logger.debug("Adding ticket {}", ticket);
		Jedis jedis = jedisSentinelPool.getResource();
		String ticketId = ticket.getId();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(ticket);
		} catch (IOException e) {
			// TODO: handle exception
			logger.error("adding ticket {} to redis error.", ticket);
		} finally {
			try {
				if (null != objectOutputStream) {
					objectOutputStream.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
				logger.error("objectOutputStream closing error where adding ticket {} to redis.", ticket);
			}
		}
		jedis.setex(ticketId.getBytes(), getTimeout(ticket), byteArrayOutputStream.toByteArray());
		jedis.close();

	}

	//@SuppressWarnings({ "finally" })
	private byte[] ticket2ByteArray(Ticket ticket) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(ticket);
			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			// TODO: handle exception
			logger.error("adding ticket {} to redis error.", ticket);
		} finally {
			try {
				if (null != objectOutputStream) {
					objectOutputStream.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
				logger.error("objectOutputStream closing error where adding ticket {} to redis.", ticket);
				
			}
			
		}
		return null;

	}

	@Override
	public Ticket getTicket(String ticketId) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisSentinelPool.getResource();
		try {
			byte[] value = jedis.get(ticketId.getBytes());
			if (null == value) {
				logger.error("Failed fetching {}, ticketId is null.", ticketId);
				return null;
			}
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(value);
			ObjectInputStream objectInputStream = null;
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			final Ticket ticket = (Ticket) objectInputStream.readObject();
			if (null != ticket) {
				return getProxiedTicketInstance(ticket);
			}
		} catch (final Exception e) {
			// TODO: handle exception
			logger.error("Failed fetching {}", ticketId, e);
		} finally {
			jedis.close();
		}

		return null;
	}

	@Override
	public boolean deleteTicket(String ticketId) {
		// TODO Auto-generated method stub
		logger.debug("Deleting ticket {} ", ticketId);
		Jedis jedis = jedisSentinelPool.getResource();
		try {
			jedis.del(ticketId.getBytes());
			return true;
		} catch (final Exception e) {
			// TODO: handle exception
			logger.error("Failed deleting {}.", ticketId);
			return false;
		} finally {
			jedis.close();
		}

	}

	@Override
	public Collection<Ticket> getTickets() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("GetTickets not supported.");

	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		jedisSentinelPool.destroy();

	}

	@Override
	protected void updateTicket(final Ticket ticket) {
		// TODO Auto-generated method stub
		logger.debug("Updating ticket {}", ticket);
		Jedis jedis = jedisSentinelPool.getResource();
		String ticketId = ticket.getId();
		try {
			// jedis.expire(ticketId.getBytes(), getTimeout(ticket));
			jedis.setex(ticketId.getBytes(), this.getTimeout(ticket), ticket2ByteArray(ticket));
		} catch (final Exception e) {
			// TODO: handle exception
			logger.error("Failed updating {}", ticket, e);
		} finally {
			jedis.close();
		}

	}

	private int getTimeout(final Ticket ticket) {
		// TODO Auto-generated method stub
		if (ticket instanceof TicketGrantingTicket) {
			return this.tgt_time;
		} else if (ticket instanceof ServiceTicket) {
			return this.st_time;
		}
		throw new IllegalArgumentException("Invalid ticket type");

	}

	public JedisSentinelPool getJedisPool() {
		return jedisSentinelPool;
	}

	public void setJedisSentinelPool(JedisSentinelPool jedisSentinelPool) {
		this.jedisSentinelPool = jedisSentinelPool;
	}

	public int getSt_time() {
		return st_time;
	}

	public void setSt_time(int st_time) {
		this.st_time = st_time;
	}

	public int getTgt_time() {
		return tgt_time;
	}

	public void setTgt_time(int tgt_time) {
		this.tgt_time = tgt_time;
	}

	@Override
	protected boolean needsCallback() {
		// TODO Auto-generated method stub
		return true;
	}

}