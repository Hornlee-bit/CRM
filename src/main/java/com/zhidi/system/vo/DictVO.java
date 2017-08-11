package com.zhidi.system.vo;

import com.zhidi.system.entity.Dict;

/**
 * Created by Administrator on 2017-07-31.
 */
public class DictVO {
    private String id;
    private String dictcode;
    private String dictname;
    private String dictnote;
    private String dictvalue;
    private String dictTypeName;
    private String dictTypeId;

    public String getDictTypeId() {
        return dictTypeId;
    }

    public void setDictTypeId(String dictTypeId) {
        this.dictTypeId = dictTypeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictcode() {
        return dictcode;
    }

    public void setDictcode(String dictcode) {
        this.dictcode = dictcode;
    }

    public String getDictname() {
        return dictname;
    }

    public void setDictname(String dictname) {
        this.dictname = dictname;
    }

    public String getDictnote() {
        return dictnote;
    }

    public void setDictnote(String dictnote) {
        this.dictnote = dictnote;
    }

    public String getDictvalue() {
        return dictvalue;
    }

    public void setDictvalue(String dictvalue) {
        this.dictvalue = dictvalue;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    public static DictVO fromDict(Dict dict){
        if(dict!=null){
            DictVO dictVO = new DictVO();
            dictVO.setId(dict.getId());
            dictVO.setDictcode(dict.getDictcode());
            dictVO.setDictname(dict.getDictname());
            dictVO.setDictnote(dict.getDictnote());
            dictVO.setDictvalue(dict.getDictvalue());
            if(dict.getDictType()!=null){
                dictVO.setDictTypeName(dict.getDictType().getTypename());
                dictVO.setDictTypeId(dict.getDictType().getId());
            }
            return dictVO;
        }
        return null;
    }
}
