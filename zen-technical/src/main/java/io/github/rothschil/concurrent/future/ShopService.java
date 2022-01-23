package io.github.rothschil.concurrent.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ShopService {

    private static List<Shop> shops = Arrays.asList(new Shop("123"),new Shop("456"),new Shop("890"),new Shop("C123"));

    public static List<String> findPriceSync(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %d",
                        shop.getCode(), shop.getPrice(product)))  //格式转换
                .collect(Collectors.toList());
    }

    public static List<String> findPriceAsync(String product) {
        List<CompletableFuture<String>> completableFutures = shops.stream().map(shop -> CompletableFuture.supplyAsync(()->
                String.format("%s price is %d",
                        shop.getCode(), shop.getPrice(product)))).collect(Collectors.toList());

        return completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
}
