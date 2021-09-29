package com.example.android.mowik;

public class word {
    private String mdefaulttrans;
    private String mmowiktrans;
    private int mResourceId=0;
    private int  msongid;
    public word(String defaulttrans,String mowiktrans ,int songid   )
    {
        mdefaulttrans=defaulttrans;
        mmowiktrans=mowiktrans;
        msongid=songid;


    }




    public word(String defaulttrans,String mowiktrans,int ResourceId,int songid )
    {
        mdefaulttrans=defaulttrans;
        mmowiktrans=mowiktrans;
        mResourceId=ResourceId;
        msongid=songid;

    }
    public int getRsourceId(){return mResourceId;}
    public String getdefaultword()
    {
        return mdefaulttrans;
    }
    public String getMmowiktrans()
    {
        return mmowiktrans;
    }
    public int getMsongid(){return msongid;}

};
