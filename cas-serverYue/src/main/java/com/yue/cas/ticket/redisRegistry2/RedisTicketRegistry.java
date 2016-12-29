package com.yue.cas.ticket.redisRegistry2;

import org.jasig.cas.ticket.ServiceTicket;
import org.jasig.cas.ticket.Ticket;
import org.jasig.cas.ticket.TicketGrantingTicket;
import org.jasig.cas.ticket.registry.AbstractDistributedTicketRegistry;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.data.redis.core.RedisTemplate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public final class RedisTicketRegistry extends AbstractDistributedTicketRegistry implements DisposableBean {

	/** Redis client. */
	@NotNull
	private final RedisTemplate<String, Object> redisTemplate;

	/**
	 * TGT cache entry timeout in seconds.
	 */
	@Min(0)
	private final int tgtTimeout;

	/**
	 * ST cache entry timeout in seconds.
	 */
	@Min(0)
	private final int stTimeout;

	public RedisTicketRegistry(RedisTemplate<String, Object> redisTemplate, int tgtTimeout, int stTimeout) {
		this.redisTemplate = redisTemplate;
		this.tgtTimeout = tgtTimeout;
		this.stTimeout = stTimeout;
	}

	//@Override
	public void addTicket(Ticket ticket) {
		logger.debug("Adding ticket {}", ticket);
		try {
			String ticketId=ticket.getId();
			int timeOut=getTimeout(ticket);
			
			this.redisTemplate.opsForValue().set(ticketId, ticket, timeOut, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.error("Failed adding {}", ticket, e);
		}

	}
	
	@SuppressWarnings({ "finally", "unused" })
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
			return null;
		}

	}

	//@Override
	public Ticket getTicket(String ticketId) {
		try {
			final Ticket t = (Ticket) this.redisTemplate.opsForValue().get(ticketId);
			if (t != null) {
				return getProxiedTicketInstance(t);
			}
		} catch (final Exception e) {
			logger.error("Failed fetching {} ", ticketId, e);
		}
		return null;
	}

	//@Override
	public boolean deleteTicket(String ticketId) {
		if (ticketId == null) {
			return false;
		}

		final Ticket ticket = getTicket(ticketId);
		if (ticket == null) {
			return false;
		}

		logger.debug("Deleting ticket {}", ticketId);
		try {
			this.redisTemplate.delete(ticketId);
		} catch (final Exception e) {
			logger.error("Failed deleting {}", ticketId, e);
		}
		return false;
	}

	@Override
	protected void updateTicket(Ticket ticket) {
		logger.debug("Updating ticket {}", ticket);
		String ticketId=ticket.getId();
		int timeOut=getTimeout(ticket);
		
		try {
			if (this.redisTemplate.hasKey(ticketId)) {
				this.redisTemplate.opsForValue().set(ticketId, ticket, timeOut, TimeUnit.SECONDS);
			}
		} catch (final Exception e) {
			logger.error("Failed updating {}", ticket, e);
		}
	}

	//@Override
	public Collection<Ticket> getTickets() {
		throw new UnsupportedOperationException("GetTickets not supported.");
	}

	@Override
	protected boolean needsCallback() {
		return true;
	}

	//@Override
	public void destroy() throws Exception {

	}

	/**
	 * Gets the timeout value for the ticket.
	 *
	 * @param t
	 *            the t
	 * @return the timeout
	 */
	private int getTimeout(final Ticket t) {
		if (t instanceof TicketGrantingTicket) {
			return this.tgtTimeout;
		} else if (t instanceof ServiceTicket) {
			return this.stTimeout;
		}
		throw new IllegalArgumentException("Invalid ticket type");
	}
}