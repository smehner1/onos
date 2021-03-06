/*
 * Copyright 2015-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.pcepio.protocol;

import java.util.LinkedList;

import org.jboss.netty.buffer.ChannelBuffer;
import org.onosproject.pcepio.exceptions.PcepParseException;
import org.onosproject.pcepio.types.PcepObjectHeader;
import org.onosproject.pcepio.types.PcepValueType;

/**
 * Abstraction of an entity providing PCEP RRO Object.
 */
public interface PcepRroObject {

    /**
     * Returns list of SubObjects.
     *
     * @return list of SubObjects
     */
    LinkedList<PcepValueType> getSubObjects();

    /**
     * Sets list of SubObjects and return its builder.
     *
     * @param llSubObjects list of SubObjects
     */
    void setSubObjects(LinkedList<PcepValueType> llSubObjects);

    /**
     * Writes the RRO Object into channel buffer.
     *
     * @param bb channel buffer
     * @return Returns the writerIndex of this buffer
     * @throws PcepParseException when object header failed to write in channel buffer
     */
    int write(ChannelBuffer bb) throws PcepParseException;

    /**
     * Builder interface with get and set functions to build RRO object.
     */
    interface Builder {

        /**
         * Builds RRO Object.
         *
         * @return RRO Object
         */
        PcepRroObject build();

        /**
         * Returns RRO object header.
         *
         * @return RRO object header
         */
        PcepObjectHeader getRroObjHeader();

        /**
         * Sets RRO object header and returns its builder.
         *
         * @param obj RRO object header
         * @return Builder by setting RRO object header
         */
        Builder setRroObjHeader(PcepObjectHeader obj);

        /**
         * Returns list of SubObjects.
         *
         * @return list of SubObjects
         */
        LinkedList<PcepValueType> getSubObjects();

        /**
         * Sets list of SubObjects in RRO Object and returns its builder.
         *
         * @param llSubObjects list of SubObjects
         * @return Builder by setting list of SubObjects
         */
        Builder setSubObjects(LinkedList<PcepValueType> llSubObjects);

        /**
         * Sets P flag in RRO object header and returns its builder.
         *
         * @param value boolean value to set P flag
         * @return Builder by setting P flag
         */
        Builder setPFlag(boolean value);

        /**
         * Sets I flag in RRO object header and returns its builder.
         *
         * @param value boolean value to set I flag
         * @return Builder by setting I flag
         */
        Builder setIFlag(boolean value);
    }
}
