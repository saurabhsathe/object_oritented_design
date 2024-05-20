package Implementations.filterImplementations;

import Implementations.EntryImplementations.UnixFile;
import Interfaces.ParamFilter;

public class nameFilter implements ParamFilter {


    @Override
    public Boolean isValid(Filters filters, UnixFile entry) {
        if(filters.extension.isEmpty() || filters.extension==null){
            return true;
        }
        return entry.getExtension().equals(filters.extension);
    }
}
