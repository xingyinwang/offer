package com.wxy.ThreadLocal;

/**
 * Created by Cser_W on 2018/5/9.
 */
public class ClientThread extends Thread {
    private ProductService productService;
    public ClientThread(ProductService productService) {
        this.productService = productService;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
        productService.updateProductPrice(1,3000);
    }
}
