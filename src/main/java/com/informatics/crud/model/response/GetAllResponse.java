package com.informatics.crud.model.response;

import com.informatics.crud.model.UserModel;
import java.util.List;

/**
 * @author Ali Alavi
 */

public class GetAllResponse {

   private int totalPages;
   private int pageSize;
   private List<UserModel> list;


    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<UserModel> getList() {
        return list;
    }

    public void setList(List<UserModel> list) {
        this.list = list;
    }
}