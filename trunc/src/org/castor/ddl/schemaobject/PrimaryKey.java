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

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all primary keys.
 * 
 * @author <a href="mailto:leducbao@gmail.com">Le Duc Bao</a>
 */
public abstract class PrimaryKey extends AbstractSchemaObject {
    //--------------------------------------------------------------------------

    /** List of primary key fields. */
    private List _fields = new ArrayList();

    /** Table the primary key is used for. */
    private Table _table;

    //--------------------------------------------------------------------------
    
    /**
     * Add given field to list of primary key fields.
     * 
     * @param field Field to add to list of primary key fields.
     */
    public final void addField(final Field field) {
        _fields.add(field);
    }
    
    /**
     * Get number of primary key fields.
     * 
     * @return Number of primary key fields.
     */
    public final int getFieldCount() {
        return _fields.size();
    }
    
    /**
     * Get primary key field at given index.
     * 
     * @param index Index of primary key field to return.
     * @return Primary key field at given index.
     */
    public final Field getField(final int index) {
        return (Field) _fields.get(index);
    }
    
    /**
     * Set table the primary key is used for.
     * 
     * @param table Table the primary key is used for.
     */
    public final void setTable(final Table table) {
        _table = table;
    }

    /**
     * Get table the primary key is used for.
     * 
     * @return Table the primary key is used for.
     */
    public final Table getTable() {
        return _table;
    }

    //--------------------------------------------------------------------------

    /**
     * Concatenate all field names delimited by field delimiter and whitespace.
     * 
     * @return Field names delimited by field delimiter and whitespace.
     */
    protected final String fieldNames() {
        String delimiter = getConfiguration().getSqlFieldDelimeter();
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < getFieldCount(); i++) {
            if (i > 0) { sb.append(delimiter).append(' '); }
            sb.append(getField(i).getName());
        }
        return sb.toString();
    }

    //--------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public final String toDropDDL() {
        return "";
    }
    
    //--------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public final boolean equals(final Object other) {
        if (other == this) { return true; }
        if (other == null) { return false; }
        if (other.getClass() != this.getClass()) { return false; }
        
        PrimaryKey pk = (PrimaryKey) other;
        return equals(getName(), pk.getName())
            && equals(_table, pk._table)
            && equals(_fields, pk._fields);
    }

    /**
     * {@inheritDoc}
     */
    public final int hashCode() {
        int hashCode = 0;
        if (getName() != null) { hashCode += getName().hashCode(); }
        hashCode *= HASHFACTOR;
        if (_table != null) { hashCode += _table.hashCode(); }
        hashCode *= HASHFACTOR;
        hashCode += _fields.hashCode();
        return hashCode;
    }

    //--------------------------------------------------------------------------
}
