// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
    production              : false,
    hmr                     : false,
    itemsPerPage            : 5,
    baseUrl                 : "http://localhost:8087",

    login                   : "/authentication/api/auth/login",
    register                : "/authentication/api/normal-user/register",
    getAllNormalUsers       : "/authentication/api/normal-user/all",
    getAllAgents            : "/authentication/api/agent/all",

    vehicleDetails          : "/vehicle",
    getAllVehicles          : "/vehicle/all",
    createNewVehicle        : "/vehicle/createVehicle",

    createNewAd             : "/ad-service/create",
    getAllAds               : "/ad-service/getAds",
    searchAd                : "/ad-service/search",

    getAllSentMessages      : "/message-microservice/api/sender/allMessages",
    getAllReceivedMessages  : "/message-microservice/api/receiver/allMessages",

    createCarRentRequest    : "/request-microservice/api/request/createRequest",
    getRequestDetails       : "/request-microservice/api/request/requestToShowForUser",
    acceptRequestToRent     : "/request-microservice/api/request/acceptRequest",
    declineRequestToRent    : "/request-microservice/api/request/declineRequest",
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
