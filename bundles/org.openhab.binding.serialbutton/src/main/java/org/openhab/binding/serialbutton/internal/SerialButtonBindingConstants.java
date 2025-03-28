/*
 * Copyright (c) 2010-2025 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.serialbutton.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.thing.ThingTypeUID;

/**
 * The {@link SerialButtonBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Kai Kreuzer - Initial contribution
 */
@NonNullByDefault
public class SerialButtonBindingConstants {

    private static final String BINDING_ID = "serialbutton";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_BUTTON = new ThingTypeUID(BINDING_ID, "button");

    // List of all Channel ids
    public static final String TRIGGER_CHANNEL = "button";

    // Config parameters
    public static final String PARAMETER_CONFIG = "port";
}
