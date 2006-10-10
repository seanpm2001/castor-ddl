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

import org.castor.ddl.Configuration;
import org.castor.ddl.GeneratorException;

/**
 * Interface for all schema objects.
 * 
 * @author <a href="mailto:leducbao@gmail.com">Le Duc Bao</a>
 */
public interface SchemaObject {
    //--------------------------------------------------------------------------

    /**
     * Set configuration of the schema object.
     * 
     * @param config Configuration to be used by the schema object.
     */
    void setConfiguration(Configuration config);
    
    /**
     * Get configuration of the schema object.
     * 
     * @return Configuration of the schema object.
     */
    Configuration getConfiguration();
    
    /**
     * Set name of the schema object.
     * 
     * @param name Name of the schema object.
     */
    void setName(final String name);
    
    /**
     * Get name of the schema object.
     * 
     * @return Name of the schema object.
     */
    String getName();
    
    //--------------------------------------------------------------------------

    /**
     * Build create script for the schema object.
     * 
     * @return Create script for the schema object.
     * @throws GeneratorException If generation of the script failed or is not supported.
     */
    String toCreateDDL() throws GeneratorException;
    
    /**
     * Build drop script for the schema object.
     * 
     * @return Drop script for the schema object.
     * @throws GeneratorException If generation of the script failed or is not supported.
     */
    String toDropDDL() throws GeneratorException;

    //--------------------------------------------------------------------------
}
