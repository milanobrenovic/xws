// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
    production              : false,
    hmr                     : false,
    itemsPerPage            : 5,
    baseUrl                 : "http://localhost:8087",

    login                   : "/authentication/api/auth/login",
    register                : "/authentication/register",
    getAllNormalUsers       : "/authentication/all",
    blockNormalUser         : "/authentication/block",
    unblockNormalUser       : "/authentication/unblock",
    getAllAgents            : "/authentication/api/agent/all",
    blockAgent              : "/authentication/api/agent/block",
    unblockAgent            : "/authentication/api/agent/unblock",

    vehicleDetails          : "/vehicle",
    getAllVehicles          : "/vehicle/all",
    createNewVehicle        : "/vehicle/createVehicle",
    uploadImage             : "/vehicle/uploadImage",
    updateVehicle           : "/vehicle",
    getImage                : "/vehicle/getImage",
    getAllImages            : "/vehicle/images",
    getAllFuelTypes         : "/vehicle/fueltype/all",
    getAllTransmissionTypes : "/vehicle/transmissiontype/all",
    getAllVehicleTypes      : "/vehicle/vehicletype/all",
    createFuelType          : "/vehicle/fueltype",
    createTransmissionType  : "/vehicle/transmissiontype",
    createVehicleType       : "/vehicle/vehicletype",
    getAllVehiclesFromCart  : "/vehicle/all-vehicles-from-cart",
    searchVehicles          : "/vehicle/searchVehicles",

    createNewAd             : "/ad-service/create",
    getAllAds               : "/ad-service/getAds",
    searchAd                : "/ad-service/search",

    getAllSentMessages      : "/message-microservice/api/sender/allMessages",
    getAllReceivedMessages  : "/message-microservice/api/receiver/allMessages",

    createCarRentRequest    : "/request-microservice/api/request/createRequest",
    getRequestDetails       : "/request-microservice/api/request/requestToShowForUser",
    acceptRequestToRent     : "/request-microservice/api/request/acceptRequest",
    declineRequestToRent    : "/request-microservice/api/request/declineRequest",

    createCartRent          : "/car-rent-microservice/create",
    getCartRentId           : "/car-rent-microservice/getCartId", // /userId
    getCartRent             : "/car-rent-microservice/getCart", // /userId
    getAllCartVehicles      : "/car-rent-microservice/allVehicles", // /cartId
    addVehicleToCartRent    : "/car-rent-microservice/add", //car-rent-microservice/add/1/to/1
    createRequestFromCart   : "/car-rent-microservice/makeRequestFromCart", // /idCart
    payVehicle              : "/car-rent-microservice/pay", // /id (of request to rent)
    createNewReview         : "/car-rent-microservice/api/review/createReviewFor", // /id (of request to rent)
    requestToRentForUser    : "/car-rent-microservice/requestToShowForUserThatRequested", // /id (of normal user)
    requestToShowForUser    : "/car-rent-microservice/requestToShowForUser", // /{id}/{role} (user/role)
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
