/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.update.operations;

import org.eclipse.core.runtime.*;
import org.eclipse.update.configuration.*;
import org.eclipse.update.core.*;

/**
 * Operation validator
 * @since 3.0
 */
public interface IOperationValidator {

	/**
	 * Called before performing install.
	 * @return the error status, or null if no errors
	 */
	public IStatus validatePendingInstall(IFeature oldFeature, IFeature newFeature);

	/**
	 * Called before performing operation.
	 * @return the error status, or null if no errors
	 */
	public IStatus validatePendingConfig(IFeature feature);
	
	/**
	 * Called before performing operation.
	 * @return the error status, or null if no errors
	 */
	public IStatus validatePendingUnconfig(IFeature feature);
	
	/**
	 * Called before performing operation.
	 * @return the error status, or null if no errors
	 */
	public IStatus validatePendingReplaceVersion(IFeature feature, IFeature anotherFeature);
	
	/**
	 * Called before processing a delta.
	 * @return the error status, or null if no errors
	 */
	public IStatus validateSessionDelta(
		ISessionDelta delta,
		IFeatureReference[] deltaRefs);

	/**
	 * Called before doing a revert/ restore operation
	 * @return the error status, or null if no errors
	 */
	public IStatus validatePendingRevert(IInstallConfiguration config);

	/**
	 * Called by the UI before doing a batched processing of
	 * several pending changes.
	 * @return the error status, or null if no errors
	 */
	public IStatus validatePendingChanges(IInstallFeatureOperation[] jobs);

	/**
	 * Check the current state.
	 * @return the error status, or null if no errors
	 */
	public IStatus validateCurrentState();
	
	/**
	 * Checks if the platform configuration has been modified outside this program.
	 * @return the error status, or null if no errors
	 */
	public IStatus validatePlatformConfigValid();
}