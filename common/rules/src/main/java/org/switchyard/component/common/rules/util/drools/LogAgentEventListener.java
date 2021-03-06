/* 
 * JBoss, Home of Professional Open Source 
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved. 
 * See the copyright.txt in the distribution for a 
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use, 
 * modify, copy, or redistribute it subject to the terms and conditions 
 * of the GNU Lesser General Public License, v. 2.1. 
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details. 
 * You should have received a copy of the GNU Lesser General Public License, 
 * v.2.1 along with this distribution; if not, write to the Free Software 
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 */
package org.switchyard.component.common.rules.util.drools;

import org.apache.log4j.Logger;
import org.drools.agent.AgentEventListener;

/**
 * An AgentEventListener that uses log4j.
 *
 * @author David Ward &lt;<a href="mailto:dward@jboss.org">dward@jboss.org</a>&gt; (C) 2011 Red Hat Inc.
 */
public class LogAgentEventListener extends LogSystemEventListener implements AgentEventListener {

    private static final Logger LOGGER = Logger.getLogger(LogAgentEventListener.class);

    /**
     * Default constructor.
     */
    public LogAgentEventListener() {
        super();
    }

    /**
     * Constructor specifying an agent name.
     * @param agentName the agent name
     */
    public LogAgentEventListener(String agentName) {
        super(getAgentPrefix(agentName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final Logger getLogger() {
        return LOGGER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setAgentName(String agentName) {
        setMessagePrefix(getAgentPrefix(agentName));
    }

    private static String getAgentPrefix(String agentName) {
        return new StringBuilder()
            .append("Agent[")
            .append(String.valueOf(agentName))
            .append("]")
            .toString();
    }

}
