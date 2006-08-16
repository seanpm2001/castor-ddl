/*
 * Copyright 2006 Le Duc Bao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.castor.ddl.schemaobject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.castor.ddl.GeneratorException;
import org.castor.ddl.KeyGenNotSupportException;



/**
 * KeyGenerator is abstract class for Key generator
 * <br/>Created on Jun 23, 2006 - 5:44:13 PM
 * @author <a href="mailto:leducbao@gmail.com">Le Duc Bao</a>
 */

public abstract class KeyGenerator extends AbstractSchemaObject {
    /**logging*/
    private static final Log LOG = LogFactory.getLog(KeyGenerator.class);

    /**
     * Constructor for KeyGenerator
     */
    protected KeyGenerator() {
        super();
    }

    /**max key*/
    public static final String MAX_KEY = "MAX";

    /**high-low key*/
    public static final String HIGH_LOW_KEY = "HIGH-LOW";

    /**uuid key*/
    public static final String UUID_KEY = "UUID";

    /**identity key*/
    public static final String IDENTITY_KEY = "IDENTITY";

    /**sequence key*/
    public static final String SEQUENCE_KEY = "SEQUENCE";

    /**
     * 
     * @return hashkey
     */
    public abstract String getHashKey();
    
    /**
     * 
     * @return name
     */
    public abstract String getName();
    
    /**
     * 
     * @return alias
     */
    public abstract String getAlias();

    /**
     * 
     * @return Table
     */
    public abstract Table getTable();

    /**
     * 
     * @param table table
     */
    public abstract void setTable(final Table table);
    
    /**
     * generate DDL script for KeyGenerator including Identity key, sequence and
     * trigger
     * @return ddl script
     * @throws KeyGenNotSupportException key gen exception
     */
    public abstract String toDDL() throws KeyGenNotSupportException;

    /**
     * @param keyGenerator key-gen
     * @exception GeneratorException throw an exception of key-gens cannot be merged.
     */
    public final void merge(final KeyGenerator keyGenerator) throws GeneratorException {
        String hashkey = getHashKey();
        if (keyGenerator == null || hashkey == null 
                || !hashkey.equalsIgnoreCase(keyGenerator.getHashKey())) {
            String message = "Merge table has different key generator, '"
                + hashkey + "' vs '" + keyGenerator.getHashKey() + "'";
            LOG.warn(message);
        }
    }
}
