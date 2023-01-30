package com.rezzza.transvisiontestapp.data;

import com.rezzza.transvisiontestapp.R;
import com.rezzza.transvisiontestapp.model.Category;

import java.util.ArrayList;

public final class CategoryData {

    public static ArrayList<Category> getList(int categoryId){
        if (categoryId == 5){
            return getTravel();
        }
        else if (categoryId == 4){
            return getOtomotif();
        }
        else if (categoryId == 3){
            return getFashion();
        }
        else if (categoryId == 6){
            return getEntertainment();
        }
        else if (categoryId == 2){
            return getOthers();
        }
        else {
            return getFood();
        }
    }
    public static ArrayList<Category> getFood(){
        ArrayList<Category> data = new ArrayList<>();
        String [] names = {"Menu asik Bakso boedjangan","Mie Ayam Gondangdia","Gado-gado Bon-Bin","Restoran Trio",
                "Menu asik Bakso boedjangan","Mie Ayam Gondangdia","Gado-gado Bon-Bin","Restoran Trio"};
        int [] images = {R.drawable.food4,R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food1,R.drawable.food2,R.drawable.food3};
        for (int i=0; i<names.length; i++){
            Category category = new Category();
            category.setTitle(names[i]);
            category.setImageRes(images[i]);
            data.add(category);
        }

        return data;
    }

    public static ArrayList<Category> getTravel(){
        ArrayList<Category> data = new ArrayList<>();
        String [] names = {"Tiket Dunia Fantasi (Dufan) Ancol","Tidung Solata Homestay","Pulau Kanawa",
                "Pulau Padar","Tiket Dunia Fantasi (Dufan) Ancol","Tidung Solata Homestay","Pulau Kanawa","Pulau Padar"};
        int [] images = {R.drawable.travel1,R.drawable.travel2,R.drawable.travel3,R.drawable.travel4,
                R.drawable.travel1,R.drawable.travel2,R.drawable.travel3,R.drawable.travel4};
        for (int i=0; i<names.length; i++){
            Category category = new Category();
            category.setTitle(names[i]);
            category.setImageRes(images[i]);
            data.add(category);
        }

        return data;
    }
    public static ArrayList<Category> getOtomotif(){
        ArrayList<Category> data = new ArrayList<>();
        String [] names = {"Penyebab Putaran Mesin Mobil Diesel Suka Ngelag","Citroen C3 Transmisi Matik Ditanyakan"
                ,"Sering Disepelekan, Apa Pentingnya Melakukan Rotasi Ban?","Cerita Veloz Asal Indonesia Ditolak Servis di Bengkel Toyota China",
                "Penyebab Putaran Mesin Mobil Diesel Suka Ngelag","Citroen C3 Transmisi Matik Ditanyakan"
                ,"Sering Disepelekan, Apa Pentingnya Melakukan Rotasi Ban?","Cerita Veloz Asal Indonesia Ditolak Servis di Bengkel Toyota China"};
        int [] images = {R.drawable.otomotif1,R.drawable.otomotif2,R.drawable.otomotif3,R.drawable.otomotif4,
                R.drawable.otomotif1,R.drawable.otomotif2,R.drawable.otomotif3,R.drawable.otomotif4};
        for (int i=0; i<names.length; i++){
            Category category = new Category();
            category.setTitle(names[i]);
            category.setImageRes(images[i]);
            data.add(category);
        }

        return data;
    }

    public static ArrayList<Category> getFashion(){
        ArrayList<Category> data = new ArrayList<>();
        String [] names = {"Ekosistem Praktik Fesyen Berkelanjutan","Tampilan Lebih Berani dan Optimis di Tren Fesyen 2023"
                ,"5 Tren Fashion Hijab yang Bakal Jadi Primadona di Tahun 2023","Jakarta Fashion Trend 2023",
                "Ekosistem Praktik Fesyen Berkelanjutan","Tampilan Lebih Berani dan Optimis di Tren Fesyen 2023"
                ,"5 Tren Fashion Hijab yang Bakal Jadi Primadona di Tahun 2023","Jakarta Fashion Trend 2023"};
        int [] images = {R.drawable.fashion1,R.drawable.fashion2,R.drawable.fashion3,R.drawable.fashion4,
                R.drawable.fashion1,R.drawable.fashion2,R.drawable.fashion3,R.drawable.fashion4};
        for (int i=0; i<names.length; i++){
            Category category = new Category();
            category.setTitle(names[i]);
            category.setImageRes(images[i]);
            data.add(category);
        }
        return data;
    }
    public static ArrayList<Category> getEntertainment(){
        ArrayList<Category> data = new ArrayList<>();
        String [] names = {"Plesetkan Lirik, Duta Bikin Ngakak di Konser Sheila On 7","Bergoyang Koplo di Festival Pekan Gembira Ria Edisi Ketiga"
                ,"Fix Konser di Stadion Utama Gelora Bung Karno","Pongki Barata Rilis Karya Terbaru Bertajuk Hati yang Terang",
                "Plesetkan Lirik, Duta Bikin Ngakak di Konser Sheila On 7","Bergoyang Koplo di Festival Pekan Gembira Ria Edisi Ketiga"
                ,"Fix Konser di Stadion Utama Gelora Bung Karno","Pongki Barata Rilis Karya Terbaru Bertajuk Hati yang Terang"};
        int [] images = {R.drawable.entertainment1,R.drawable.entertainment2,R.drawable.entertainment3,R.drawable.entertainment4,
                R.drawable.entertainment1,R.drawable.entertainment2,R.drawable.entertainment3,R.drawable.entertainment4};
        for (int i=0; i<names.length; i++){
            Category category = new Category();
            category.setTitle(names[i]);
            category.setImageRes(images[i]);
            data.add(category);
        }
        return data;
    }
    public static ArrayList<Category> getOthers(){
        ArrayList<Category> data = new ArrayList<>();
        String [] names = {"Cucumber & Coriander Smoothie Recipe","Adrak Wali Chai Recipe"
                ,"Plum & date sharbat milk Recipe","Cucumber, Kale And Spinach Juice Recipe",
                "Cucumber & Coriander Smoothie Recipe","Adrak Wali Chai Recipe"
                ,"Plum & date sharbat milk Recipe","Cucumber, Kale And Spinach Juice Recipe"};
        int [] images = {R.drawable.beverages1,R.drawable.beverages2,R.drawable.beverages3,R.drawable.beverages4,
                R.drawable.beverages1,R.drawable.beverages2,R.drawable.beverages3,R.drawable.beverages4};
        for (int i=0; i<names.length; i++){
            Category category = new Category();
            category.setTitle(names[i]);
            category.setImageRes(images[i]);
            data.add(category);
        }
        return data;
    }
}
