package Implementations.filterImplementations;

import Implementations.EntryImplementations.UnixFile;
import Interfaces.ParamFilter;

public class maxSizeFilter implements ParamFilter {

    public Boolean isValid(Filters filters, UnixFile entry) {
        if(filters.maxSize==0 ){
            return true;
        }
        return entry.getSize()<=filters.maxSize;
    }


}
