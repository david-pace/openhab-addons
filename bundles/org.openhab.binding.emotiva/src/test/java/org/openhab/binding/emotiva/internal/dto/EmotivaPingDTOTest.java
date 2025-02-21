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
package org.openhab.binding.emotiva.internal.dto;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.xml.bind.JAXBException;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.junit.jupiter.api.Test;
import org.openhab.binding.emotiva.internal.AbstractDTOTestBase;

/**
 * Unit tests for EmotivaPing message type.
 *
 * @author Espen Fossen - Initial contribution
 */
@NonNullByDefault
class EmotivaPingDTOTest extends AbstractDTOTestBase {

    public EmotivaPingDTOTest() throws JAXBException {
    }

    @Test
    void marshallPlain() {
        var dto = new EmotivaPingDTO();
        String xmlAsString = xmlUtils.marshallEmotivaDTO(dto);

        assertThat(xmlAsString, containsString("<emotivaPing/>"));
        assertThat(xmlAsString, not(containsString("<property")));
        assertThat(xmlAsString, not(containsString("</emotivaPing>")));
    }

    @Test
    void marshallWithProtocol() {
        var dto = new EmotivaPingDTO("3.0");
        String xmlAsString = xmlUtils.marshallEmotivaDTO(dto);

        assertThat(xmlAsString, containsString("<emotivaPing protocol=\"3.0\"/>"));
        assertThat(xmlAsString, not(containsString("<property")));
        assertThat(xmlAsString, not(containsString("</emotivaPing>")));
    }

    @Test
    void unmarshallV2() throws JAXBException {
        var dto = (EmotivaPingDTO) xmlUtils.unmarshallToEmotivaDTO(emotivaPingV2);

        assertThat(dto, is(notNullValue()));
        assertThat(dto.getProtocol(), is(nullValue()));
    }

    @Test
    void unmarshallV3() throws JAXBException {
        var dto = (EmotivaPingDTO) xmlUtils.unmarshallToEmotivaDTO(emotivaPingV3);

        assertThat(dto, is(notNullValue()));
        assertThat(dto.getProtocol(), is(notNullValue()));
        assertThat(dto.getProtocol(), is("3.0"));
    }
}
