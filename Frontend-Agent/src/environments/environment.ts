// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
    production          : false,
    hmr                 : false,
    itemsPerPage        : 5,
    baseUrl             : "http://localhost:8080",
    login               : "/api/auth/login",
    register            : "/api/auth/user/register",
    createNewVehicle    : "/api/vehicle/createVehicle",
    createNewAd         : "/api/ad/create",
    getAllVehicles      : "/api/vehicle/all",
    searchAd            : "/api/ad/search",
    vehicleDetails      : "/api/vehicle",
    vehicleMostKM       : "/api/vehicle/mostKM",
    vehicleBestGrade    : "/api/vehicle/best-grade",
    uploadImage         : "/api/image/uploadImage",
    updateVehicle       : "/api/vehicle",
    getImage            : "/api/image/getImage"
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
