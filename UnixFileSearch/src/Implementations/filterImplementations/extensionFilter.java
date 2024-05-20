package Implementations.filterImplementations;

import Implementations.EntryImplementations.UnixFile;
import Interfaces.Entry;
import Interfaces.ParamFilter;

public class extensionFilter implements ParamFilter {
    @Override
    public Boolean isValid(Filters filters, UnixFile entry) {
        if(filters.name.isEmpty() || filters.name==null){
            return true;
        }
        return entry.getExtension().equals(filters.name);
    }
}
