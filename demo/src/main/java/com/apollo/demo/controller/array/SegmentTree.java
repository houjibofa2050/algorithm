package com.apollo.demo.controller.array;

import javax.sound.midi.Soundbank;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-09-01 07:41
 * @email: fuguowen@fantaike.ai
 */
public class SegmentTree {

    public void buildSegmentTree(int[] value,int[] nums,int pos,int left,int right){
        if(left==right){
            value[pos]=nums[left];
            return ;
        }
        int mid=(left+right)/2;
        buildSegmentTree(value,nums,pos*2+1,left,mid);
        buildSegmentTree(value,nums,pos*2+2,mid+1,right);
        value[pos]=value[pos*2+1]+value[pos*2+2];
    }

    public int sumSegmentTree(int[] value,int pos,int left,int right,int qleft,int qright){
        if(qleft>right || qright<left){
            return 0;
        }
        if(qleft<=left && qright>=right){
            return value[pos];
        }
        int mid=(left+right)/2;
        return sumSegmentTree(value,pos*2+1,left,mid,qleft,qright)+ sumSegmentTree(value,pos*2+2,mid+1,right,qleft,qright);
    }

    public void updateSegmentTree(int[] value,int pos,int left,int right,int index,int newValue){
        if(left==right&& left==index){
            value[pos]=newValue;
            return;
        }
        int mid=(left+right)/2;

        if(index<=mid){
            updateSegmentTree(value,pos*2+1,left,mid,index,newValue);
        }else{
            updateSegmentTree(value,pos*2+2,mid+1,right,index,newValue);
        }
        value[pos]=value[2*pos+1]+value[2*pos+2];
    }

    public void printSegmentTree(int[] value,int pos,int left,int right,int layer){
        for(int i=0;i<layer;i++){
            System.out.print("---");
        }
        System.out.println("left:"+left+" right:"+right+" pos: "+pos+" value[pos]:"+value[pos]);
        if(left==right){
            return ;
        }
        int mid=(left+right)/2;
        printSegmentTree(value,pos*2+1,left,mid,layer+1);
        printSegmentTree(value,pos*2+2,mid+1,right,layer+1);

    }
}
