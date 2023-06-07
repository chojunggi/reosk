
        const products = [
            { name: '레몬에이드', price: 4500, imgUrl: '/assets/img/lemonade.jpg' },
            { name: '체리에이드', price: 4500, imgUrl: '/assets/img/cheade.jpg' },
            { name: '랜덤에이드', price: 4500, imgUrl: '/assets/img/randomade.jpg' }
        ];

        const productContainer = document.getElementById('productContainer');

        for (const product of products) {
            const productCard = `
                <div class="col mb-5">
                    <div class="card h-100">
                        <a onclick="addToCart('${product.name}', ${product.price}, '${product.imgUrl}');">
                            <!-- Product image-->
                            <img class="card-img-top" src="${product.imgUrl}" width="300px" height="300px" alt="..."/>
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">${product.name}</h5>
                                    <!-- Product price-->
                                    ${product.price}원
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center">
                                </div>
                                <br>
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" value="add_hTag" onclick="addToCart('${product.name}', ${product.price}, '${product.imgUrl}');" id="ddd">장바구니 담기</a></div>
                            </div>
                        </a>
                    </div>
                </div>
            `;

            productContainer.innerHTML += productCard;
        }

        function addToCart(name, price, imgUrl) {
            // 장바구니에 상품 추가하는 코드
        }
