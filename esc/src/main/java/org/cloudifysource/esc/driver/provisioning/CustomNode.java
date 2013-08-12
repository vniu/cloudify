/*******************************************************************************
 * Copyright (c) 2012 GigaSpaces Technologies Ltd. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.cloudifysource.esc.driver.provisioning;

import java.net.UnknownHostException;

/**
 * Interface for a custom cloud node, used for example by the BYON cloud driver.
 * 
 * @author noak
 * @since 2.0.1
 */
public interface CustomNode {

	/**
	 * @return id of the server within the naming scope it was created. potentially generated by the service.
	 */
	String getProviderId();

    String getHostName();

	/**
	 * 
	 * A means to uniquely address this resource within a provider. For example, if the namespace of a node or
	 * image is region based, the id will likely include both the region and the provider-supplied id encoded
	 * to avoid collisions.
	 * 
	 * @return unique id within your account on the provider
	 */
	String getId();

	/**
	 * @return the TCP port used for terminal connections. Generally, this is port 22 for ssh.
	 */
	int getLoginPort();

	/**
	 * Gets the user name required to log in to the node.
	 * 
	 * @return The username as a {@link String}
	 */
	String getUsername();

	/**
	 * Gets the password required to log in to the node.
	 * 
	 * @return The password as a {@link String}
	 */
	String getCredential();
	
	/**
	 * Gets the private key required to log in to the node.
	 * 
	 * @return The private key as a {@link String}
	 */
	String getKeyFile();

	/**
	 * Gets the public IP address, the IP address used for external communication.
	 * 
	 * @return The public IP address as a {@link String}
	 */
	String getPublicIP();

	/**
	 * Gets the private IP address (or host name), used for internal communication.
	 * 
	 * @return The private IP address as a {@link String}
	 */
	String getPrivateIP();

    /**
     * Resolve the addresses of this node. this method should populate the privateIp and hostName fields of the node
     * with the resolved value as defined in the network.
     * @throws UnknownHostException .
     */
    void resolve() throws UnknownHostException;

	/**
	 * Sets the node name.
	 * 
	 * @param nodeName
	 *            A user defined name of the server.
	 */
	void setNodeName(String nodeName);

	/**
	 * Gets the node name.
	 * 
	 * @return user defined name for the node.
	 */
	String getNodeName();

	/**
	 * Sets the node's group.
	 * 
	 * @param group
	 *            The group name
	 */
	void setGroup(final String group);

	/**
	 * Tag used for all resources that belong to the same logical group. run, destroy commands are scoped to
	 * group.
	 * 
	 * @return group for this node, or null, if not a part of a group
	 * 
	 */
	String getGroup();

	/*********************
	 * Sets the login port for this node.
	 * @param loginPort the login port.
	 */
	void setLoginPort(final int loginPort);
	
    /**
     * Prints this node's main details, for short print outs.
     * @return this node's main details, as a String.
     */
	String toShortString();
}
