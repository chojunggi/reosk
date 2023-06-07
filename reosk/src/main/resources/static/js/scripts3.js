                document.getElementById('cartForm').addEventListener('submit', function(event) {
                    // Prevent the default form submission behavior
                    event.preventDefault();

                    // Convert the cart array to a JSON string
                    const cartData = JSON.stringify(cart);

                    // Set the value of the hidden input field to the JSON string
                    document.getElementById('cartData').value = cartData;

                    // Finally, submit the form
                    event.target.submit();
                });           
           
            let cart = [];

            function addToCart(productName, price, srcc,pcode,mcode) {
                const cartList = document.getElementById('cartList');
                const existingCartItem = cart.find(item => item.name === productName);

                if (existingCartItem) {
                    existingCartItem.quantity += 1;
                    document.getElementById(`cart-item-quantity-${existingCartItem.name}`).innerHTML = `
                    <a onclick="minus('${productName}');"><img class="card-img-top" src="/assets/img/mi.png" alt="..." style="width:30px; height:30px;" /></a>
                    ${existingCartItem.quantity}
                    <a onclick="plus('${productName}');"><img class="card-img-top" src="/assets/img/pl.png" alt="..." style="width:30px; height:30px;" /></a>
                    `;
                } else {
                    const newCartItem = {name: productName, price: price, quantity: 1};
                    cart.push(newCartItem);

                    const cartItem = document.createElement('div');
                    cartItem.setAttribute('class', 'cart-item');
                    cartItem.innerHTML = `
                    <img src="${srcc}" alt="..." style="width:60px; height:60px;" /><p  font-size: 30px;>${productName}</p>
                    <span id="cart-item-quantity-${newCartItem.name}">
                        <a onclick="minus('${productName}');"><img class="card-img-top" src="/assets/img/mi.png" alt="..." style="width:30px; height:30px;" /></a>
                        ${newCartItem.quantity}
                        <a onclick="plus('${productName}');"><img class="card-img-top" src="/assets/img/pl.png" alt="..." style="width:30px; height:30px;" /></a>
                       <input type="hidden" id= "pcode" value=${pcode}>${pcode}</input>
                      <input type="hidden" id= "mcode" value=${mcode}>${mcode}</input>
                    </span>
                    `;
                    cartList.appendChild(cartItem);
                }
            }

                function plus(productName) {
                    const existingCartItem = cart.find(item => item.name === productName);
                    if (existingCartItem) {
                        existingCartItem.quantity += 1;
                        document.getElementById(`cart-item-quantity-${existingCartItem.name}`).innerHTML = `
                        <a onclick="minus('${productName}');"><img class="card-img-top" src="/assets/img/mi.png" alt="..." style="width:30px; height:30px;" /></a>
                        ${existingCartItem.quantity}
                        <a onclick="plus('${productName}');"><img class="card-img-top" src="/assets/img/pl.png" alt="..." style="width:30px; height:30px;" /></a>
                        `;
                    }
                }

                function minus(productName) {
                    const existingCartItem = cart.find(item => item.name === productName);
                    if (existingCartItem && existingCartItem.quantity > 1) {
                        existingCartItem.quantity -= 1;
                        document.getElementById(`cart-item-quantity-${existingCartItem.name}`).innerHTML = `
                        <a onclick="minus('${productName}');"><img class="card-img-top" src="/assets/img/mi.png" alt="..." style="width:30px; height:30px;" /></a>
                        ${existingCartItem.quantity}
                        <a onclick="plus('${productName}');"><img class="card-img-top" src="/assets/img/pl.png" alt="..." style="width:30px; height:30px;" /></a>
                        `;
                    }else if (existingCartItem && existingCartItem.quantity === 1) {
        // Decrease the quantity to 0
        existingCartItem.quantity -= 1;

        // Remove the item from the cart array
        cart = cart.filter(item => item.name !== productName);

        // Remove the item from the DOM
        const cartItem = document.getElementById(`cart-item-quantity-${existingCartItem.name}`).parentNode;
        cartItem.remove();
    }
                }