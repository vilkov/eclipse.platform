/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.ant.core;

/**
 * A security exception that is thrown by the AntSecurityManager if an Ant task in some way attempts to halt or exit the Java Virtual Machine.
 * 
 * Clients may instantiate this class; it is not intended to be subclassed.
 * 
 * @since 2.1
 * @noextend This class is not intended to be subclassed by clients.
 */
public class AntSecurityException extends SecurityException {

	private static final long serialVersionUID = 1L;

}
