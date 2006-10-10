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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Schema contains a set of table and schema options.
 * 
 * @author <a href="mailto:leducbao@gmail.com">Le Duc Bao</a>
 */
public abstract class Schema extends AbstractSchemaObject {
    //--------------------------------------------------------------------------

    /** List of tables for this schema. */
    private List _tables = new ArrayList();

    /** Map of tables assoizated with their name. */
    private Map _tableMap = new HashMap();
    
    //--------------------------------------------------------------------------

    /**
     * Add given table to list of tables.
     * 
     * @param table Table to add to list of tables.
     */
    public final void addTable(final Table table) {
        _tables.add(table);
        _tableMap.put(table.getName(), table);
    }

    /**
     * Get number of tables.
     * 
     * @return Number of tables.
     */
    public final int getTableCount() {
        return _tables.size();
    }
    
    /**
     * Get table at given index.
     * 
     * @param index Index of table to return.
     * @return Table at given index.
     */
    public final Table getTable(final int index) {
        return (Table) _tables.get(index);
    }

    /**
     * Get table with given name.
     * 
     * @param name Name of table to return.
     * @return Table with given name.
     */
    public final Table getTable(final String name) {
        return (Table) _tableMap.get(name);
    }
    
    //--------------------------------------------------------------------------
}
