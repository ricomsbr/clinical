/*
 * IPersistable.java		28/09/2015
 *
 * Copyright (C) 2015 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.model.entity;

import java.io.Serializable;

/**
 *
 *
 * @author RMendonca
 * @version @version@
 * @since @since@
 */
public interface IPersistable extends Serializable {

	Long getVersion();

	Long getId();

	void setVersion(Long version);

	void setId(Long id);

	boolean isActive();

}
