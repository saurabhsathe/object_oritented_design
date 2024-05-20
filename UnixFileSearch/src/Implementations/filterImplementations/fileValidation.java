package Implementations.filterImplementations;

import Implementations.EntryImplementations.UnixFile;
import Interfaces.Entry;
import Interfaces.ParamFilter;

import java.util.ArrayList;

public class fileValidation {
    ArrayList<ParamFilter> paramFilters;
    Filters filters;
    public  fileValidation(Filters filters){
        paramFilters = new ArrayList<>();
        paramFilters.add(new maxSizeFilter());
        paramFilters.add(new minSizeFilter());
        paramFilters.add(new extensionFilter());
        this.filters=filters;

    }
    Boolean validate(UnixFile fileName ){

        for(ParamFilter paramFilter:paramFilters){
            if (!paramFilter.isValid(filters,fileName))
                return Boolean.FALSE;
        }
        return true;

    }

}
