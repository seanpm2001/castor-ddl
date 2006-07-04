/*
 * Copyright 2006 Le Duc Bao
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.castor.ddl.schemaobject;

import org.castor.ddl.GeneratorException;
import org.castor.ddl.typeinfo.TypeInfo;

/**
 * 
 * Created on Jun 23, 2006 - 5:43:48 PM
 * 
 * @author <a href="mailto:leducbao@gmail.com">Le Duc Bao</a>
 */

public class Field extends AbstractSchemaObject {
    /** field name */
    private String _name;

    /** type infor */
    private TypeInfo _type;

    /** is identity */
    private boolean _isIdentity;

    /** handle key generator keyword */
    private KeyGenerator _keyGenerator;
    
    /**
     * Constructor for Field
     */
    public Field() {
        super();
        _name = null;
        _type = null;
        _keyGenerator = null;
    }
    
    
    /**
     * 
     * @return Returns the isIdentity.
     */
    public boolean isIdentity() {
        return _isIdentity;
    }

    /**
     * Set the isIdentity by _isIdentity.
     * 
     * @param isIdentity
     */
    public void setIdentity(boolean isIdentity) {
        _isIdentity = isIdentity;
    }

    /**
     * 
     * @return Returns the name.
     */
    public String getName() {
        return _name;
    }

    /**
     * Set the name by _name.
     * 
     * @param name
     */
    public void setName(String name) {
        _name = name;
    }

    /**
     * 
     * @return Returns the type.
     */
    public TypeInfo getType() {
        return _type;
    }

    /**
     * Set the type by _type.
     * 
     * @param type
     */
    public void setType(TypeInfo type) {
        _type = type;
    }

    /**
     * 
     * @return Returns the keyGenerator.
     */
    public KeyGenerator getKeyGenerator() {
        return _keyGenerator;
    }

    /**
     * Set the keyGenerator by _keyGenerator.
     * @param keyGenerator 
     */
    public void setKeyGenerator(KeyGenerator keyGenerator) {
        _keyGenerator = keyGenerator;
    }
    
    public Integer getLength() { return null; }

    public Integer getPrecision() { return null; }

    public Integer getDecimals() { return null; }

    /* (non-Javadoc)
     * @see org.castor.ddl.schemaobject.SchemaObject#toDDL()
     */
    public String toDDL() throws GeneratorException {
        StringBuffer buff = new StringBuffer();
        buff.append(_name).append(" ");
        /** todo review later null or field*/
        buff.append(_type.toDDL(this));
        if(_isIdentity)
            buff.append(" NOT NULL");
        
        return buff.toString();
    }
}