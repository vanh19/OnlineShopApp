package anhmvph25860.fpoly.onlineshopapp.Helper;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

import anhmvph25860.fpoly.onlineshopapp.Domain.PopularDomain;

public class ManagmentCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(PopularDomain item){
        ArrayList<PopularDomain> listPop = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listPop.size(); i++){
            if (listPop.get(i).getTitle().equals(item.getTitle())){
                existAlready = true;
                n = 1;
                break;
            }
        }
        if (existAlready){
            listPop.get(n).setNumberinCart(item.getNumberinCart());
        }else {
            listPop.add(item);
        }
        tinyDB.putListObject("CartList", listPop);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }
    private ArrayList<PopularDomain> getListCart(){
        return tinyDB.getListObject("CartList");
    }

    public void minusNumberItem(ArrayList<PopularDomain> listItem, int position, ChangeNumberItemsListener changeNumberItemsListener){
        if (listItem.get(position).getNumberinCart() == 1){
            listItem.remove(position);
        }else {
            listItem.get(position).setNumberinCart(listItem.get(position).getNumberinCart() - 1);
        }
        tinyDB.putListObject("CartList", listItem);
        changeNumberItemsListener.change();
    }
    public void plusNumberItem(ArrayList<PopularDomain> listItem, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listItem.get(position).setNumberinCart(listItem.get(position).getNumberinCart() + 1);
        tinyDB.putListObject("CartList", listItem);
        changeNumberItemsListener.change();
    }
    public Double getTotalFee(){
        ArrayList<PopularDomain> listItem = getListCart();
        double fee = 0;
        for (int i = 0; i < listItem.size(); i++){
            fee = fee + (listItem.get(i).getPrice() * listItem.get(i).getNumberinCart());
        }
        return fee;
    }
}
