/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.update.search;

/**
 * This interface is used for update site adapter used 
 * for specific query serches. It adds a mapping ID 
 * that can be used when mapping file is specified.
 * If a matching mapping is found for this ID, 
 * the replacement URL found in the mapping file will be
 * used instead of this adapter.
 */
public interface IQueryUpdateSiteAdapter extends IUpdateSiteAdapter {
/**
 * Returns an ID that can be used for matching against the information in the address mapping file.
 * @return a mapping Id to compare against the address mapping file.
 */
	public String getMappingId();

}