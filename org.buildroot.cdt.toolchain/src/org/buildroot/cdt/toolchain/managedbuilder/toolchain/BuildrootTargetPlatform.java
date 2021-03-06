/*******************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Melanie Bats <melanie.bats@obeo.fr> - Initial contribution
 *******************************************************************************/
package org.buildroot.cdt.toolchain.managedbuilder.toolchain;

import org.buildroot.cdt.toolchain.BuildrootUtils;

public class BuildrootTargetPlatform extends BuildrootConfigElement {
	private static final String BINARY_PARSER = "binaryParser";
	private String id;
	private String name;

	public BuildrootTargetPlatform(String path, String architecture) {
		id = getIdentifier(path, "platform.base");
		name = BuildrootUtils.getToolName(architecture, path, "Platform");
	}

	@Override
	public String getName() {
		return "targetPlatform";
	}

	@Override
	public String getAttribute(String attribute) {
		if (ARCH_LIST.equals(attribute))
			return "all";
		else if (BINARY_PARSER.equals(attribute))
			return "org.eclipse.cdt.core.GNU_ELF";
		else if (ID.equals(attribute))
			return id;
		else if (IS_ABSTRACT.equals(attribute))
			return "false";
		else if (NAME.equals(attribute))
			return name;
		else if (OS_LIST.equals(attribute))
			return "linux";
		return null;
	}
}
