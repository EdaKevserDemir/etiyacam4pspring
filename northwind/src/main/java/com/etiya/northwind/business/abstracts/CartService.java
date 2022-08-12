package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.carts.BuyCartRequest;
import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.dataAccess.concretes.responses.carts.CartListResponse;
import com.etiya.northwind.dataAccess.concretes.responses.carts.GetCartsByIdResponse;

import java.util.List;

public interface CartService {
    Result add(CreateCartRequest createCartRequest);
    Result update(UpdateCartRequest updateCartRequest);
    Result delete(DeleteCartRequest deleteCartRequest);

    DataResult<GetCartsByIdResponse> getById(int id);

    DataResult<List<CartListResponse>> getAll();

    Result buyCartProducts(BuyCartRequest buyCartRequest);
}
