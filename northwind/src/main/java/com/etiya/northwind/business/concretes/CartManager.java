package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.CartRepository;
import com.etiya.northwind.dataAccess.concretes.responses.carts.CartListResponse;
import com.etiya.northwind.dataAccess.concretes.responses.carts.GetCartsByIdResponse;
import com.etiya.northwind.entities.concretes.Cart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartManager implements CartService {

    private CartRepository cartRepository;
    private ModelMapperService modelMapperService;

    public CartManager(CartRepository cartRepository, ModelMapperService modelMapperService) {
        this.cartRepository = cartRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateCartRequest createCartRequest) {
       Cart cart=this.modelMapperService.forRequest().map(createCartRequest,Cart.class);
       this.cartRepository.save(cart);
       return new SuccessResult("ADDED");
    }

    @Override
    public Result update(UpdateCartRequest updateCartRequest) {
        Cart cart=this.modelMapperService.forRequest().map(updateCartRequest,Cart.class);
        this.cartRepository.save(cart);
        return new SuccessResult("UPDATED");
    }

    @Override
    public Result delete(DeleteCartRequest deleteCartRequest) {
        this.cartRepository.deleteById(deleteCartRequest.getCartId());
        return new SuccessResult("DELETED");
    }

    @Override
    public DataResult<GetCartsByIdResponse> getById(int id) {
        Cart cart=this.cartRepository.findByCartId(id);
        GetCartsByIdResponse getCartsByIdResponse=this.modelMapperService.forResponse().map(cart,GetCartsByIdResponse.class);
        return new SuccessDataResult<GetCartsByIdResponse>(getCartsByIdResponse);
    }

    @Override
    public DataResult<List<CartListResponse>> getAll() {
        List<Cart>carts=this.cartRepository.findAll();
        List<CartListResponse>responses=carts.stream().map
                (cart -> this.modelMapperService.forResponse().map(cart,CartListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(responses);
    }
    

}
