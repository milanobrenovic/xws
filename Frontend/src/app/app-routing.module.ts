import { Routes, RouterModule } from "@angular/router";
import { LoginComponent } from "./main/login/login.component";
import { HomeComponent } from "./main/home/home.component";
import { NgModule } from '@angular/core';
import { ErrorComponent } from './main/errors/error/error.component';
import { ErrorInternalServerComponent } from './main/errors/error-internal-server/error-internal-server.component';
import { ErrorPageNotFoundComponent } from './main/errors/error-page-not-found/error-page-not-found.component';
import { ErrorUnauthorizedComponent } from './main/errors/error-unauthorized/error-unauthorized.component';
import { ErrorUnauthenticatedComponent } from './main/errors/error-unauthenticated/error-unauthenticated.component';
import { RegisterComponent } from './main/register/register.component';
import { CreateNewAdComponent } from './main/create-new-ad/create-new-ad.component';
import { CreateNewVehicleComponent } from './main/create-new-vehicle/create-new-vehicle.component';
import { SearchAdComponent } from './main/search-ad/search-ad.component';
import { VehicleDetailsComponent } from './main/vehicle-details/vehicle-details.component';
import { MessagesComponent } from './main/messages/messages.component';
import { RequestToRentComponent } from './main/request-to-rent/request-to-rent.component';
import { RequestToRentDetails } from './models/requestToRentDetails';
import { RequestDetailsComponent } from './main/request-details/request-details.component';
import { UserAccessComponent } from './main/user-access/user-access.component';
import { AddImagesComponent } from './main/add-images/add-images.component';
import { AdminGuard } from './guards/admin.guard';

const appRoutes: Routes = [


    //==============================================================================//
    // INITIAL
    //==============================================================================//
    {
        path        : 'pages/login',
        component   : LoginComponent,
    },


    //==============================================================================//
    // REDIRECTIONS
    //==============================================================================//
    {
        path        : '',
        redirectTo  : 'pages/home',
        pathMatch   : 'full',
    },


    //==============================================================================//
    // PAGES
    //==============================================================================//
    {
        path        : 'pages/home',
        component   : HomeComponent,
        // canActivate : [AdminGuard],
    },
    {
        path        : 'pages/register',
        component   : RegisterComponent,
        // canActivate : [AdminGuard],
    },
    {
        path        : 'pages/create-new-vehicle',
        component   : CreateNewVehicleComponent,
        // canActivate : [AdminGuard],
    },
    {
        path        : 'pages/create-new-ad',
        component   : CreateNewAdComponent,
        // canActivate : [AdminGuard],
    },
    {
        path        : 'pages/search-ad',
        component   : SearchAdComponent,
        // canActivate : [AdminGuard],
    },
    {
        path        : 'pages/vehicle-details/:id',
        component   : VehicleDetailsComponent,
        // canActivate : [AdminGuard],
    },
    {
        path        : 'pages/messages',
        component   : MessagesComponent,
        // canActivate : [AdminGuard],
    },
    {
        path        : 'pages/request-to-rent',
        component   : RequestToRentComponent,
        // canActivate : [AdminGuard],
    },
    {
        path        : 'pages/request-to-rent-details',
        component   : RequestDetailsComponent,
        // canActivate : [AdminGuard],
    },
    {
        path        : 'pages/user-access',
        component   : UserAccessComponent,
        canActivate : [AdminGuard],
    },
    {
        path        : 'pages/add-images',
        component   : AddImagesComponent,
        // canActivate : [AdminGuard],
    },


    //==============================================================================//
    // ERRORS
    //==============================================================================//
    {
        // 401
        path        : 'errors/unauthenticated',
        component   : ErrorUnauthenticatedComponent,
    },
    {
        // 403
        path        : 'errors/unauthorized',
        component   : ErrorUnauthorizedComponent,
    },
    {
        // 404
        path        : 'errors/page-not-found',
        component   : ErrorPageNotFoundComponent,
    },
    {
        // 500
        path        : 'errors/internal-server',
        component   : ErrorInternalServerComponent,
    },
    {
        // Unrecognized endpoint
        path        : '**',
        component   : ErrorComponent,
    },
];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule],
})
export class AppRoutingModule { }
