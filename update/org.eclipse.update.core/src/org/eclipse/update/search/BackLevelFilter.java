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
package org.eclipse.update.search;

import org.eclipse.core.runtime.*;
import org.eclipse.update.core.*;
import org.eclipse.update.internal.operations.*;

/**
 * This class can be added to the update search request
 * to filter out features that are back-level (are
 * older or the same as the features already installed).
 * 
 * @see UpdateSearchRequest
 * @see IUpdateSearchFilter
 */
public class BackLevelFilter extends BaseFilter {
	public boolean accept(IFeatureReference match) {
		try {
			PluginVersionIdentifier matchVid = match.getVersionedIdentifier().getVersion();
			IFeature [] installed = UpdateUtils.getInstalledFeatures(match.getVersionedIdentifier(), false);
			if (installed.length==0) return true;
			
			for (int i=0; i<installed.length; i++) {
				PluginVersionIdentifier ivid = installed[i].getVersionedIdentifier().getVersion();
				if (matchVid.isGreaterThan(ivid))
					continue;
				// installed version is the same or newer than
				// the match - filter out
				return false;
			}
			return true;
		} catch (CoreException e) {
			return false;
		}
	}
}