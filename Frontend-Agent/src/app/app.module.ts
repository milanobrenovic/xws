import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatMomentDateModule } from '@angular/material-moment-adapter';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { TranslateModule } from '@ngx-translate/core';
import 'hammerjs';

import { FuseModule } from '@fuse/fuse.module';
import { FuseSharedModule } from '@fuse/shared.module';
import { FuseProgressBarModule, FuseSidebarModule, FuseThemeOptionsModule } from '@fuse/components';

import { fuseConfig } from 'app/fuse-config';

import { AppComponent } from 'app/app.component';
import { LayoutModule } from 'app/layout/layout.module';
import { LoginComponent } from './main/login/login.component';
import { HomeComponent } from './main/home/home.component';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { AppRoutingModule } from './app-routing.module';
import { MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { ToastrModule } from 'ngx-toastr';
import { MAT_RADIO_DEFAULT_OPTIONS, MatRadioModule } from '@angular/material/radio';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { A11yModule } from '@angular/cdk/a11y';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import { MatNativeDateModule, MatRippleModule } from '@angular/material/core';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTooltipModule } from '@angular/material/tooltip';
import { PortalModule } from '@angular/cdk/portal';
import { ScrollingModule } from '@angular/cdk/scrolling';

import { DragDropModule } from '@angular/cdk/drag-drop';
import { CdkStepperModule } from '@angular/cdk/stepper';
import { CdkTableModule } from '@angular/cdk/table';
import { CdkTreeModule } from '@angular/cdk/tree';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatBadgeModule } from '@angular/material/badge';
import { MatBottomSheetModule } from '@angular/material/bottom-sheet';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { MatStepperModule } from '@angular/material/stepper';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSliderModule } from '@angular/material/slider';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatTabsModule } from '@angular/material/tabs';
import { MatTreeModule } from '@angular/material/tree';
import { RegisterComponent } from './main/register/register.component';
import { ErrorUnauthenticatedComponent } from './main/errors/error-unauthenticated/error-unauthenticated.component';
import { ErrorUnauthorizedComponent } from './main/errors/error-unauthorized/error-unauthorized.component';
import { ErrorPageNotFoundComponent } from './main/errors/error-page-not-found/error-page-not-found.component';
import { ErrorInternalServerComponent } from './main/errors/error-internal-server/error-internal-server.component';
import { ErrorComponent } from './main/errors/error/error.component';
import { CreateNewAdComponent } from './main/create-new-ad/create-new-ad.component';
import { CreateNewVehicleComponent } from './main/create-new-vehicle/create-new-vehicle.component';
import { TokenInterceptor } from './interceptors/token.interceptor';
import { ErrorInterceptor } from './interceptors/error.interceptor';
import { SearchAdComponent } from './main/search-ad/search-ad.component';
import { VehicleDetailsComponent } from './main/vehicle-details/vehicle-details.component';
import { VehicleStatisticComponent } from './main/vehicle-statistic/vehicle-statistic.component';
import { AddImagesComponent } from './main/add-images/add-images.component';

@NgModule({
	declarations: [
		AppComponent,
		HomeComponent,
		LoginComponent,
		RegisterComponent,
		ErrorUnauthenticatedComponent,
		ErrorUnauthorizedComponent,
		ErrorPageNotFoundComponent,
		ErrorInternalServerComponent,
		ErrorComponent,
		CreateNewAdComponent,
		CreateNewVehicleComponent,
		SearchAdComponent,
		VehicleDetailsComponent,
		VehicleStatisticComponent,
		AddImagesComponent,
	],
	imports: [
		BrowserModule,
		BrowserAnimationsModule,
		HttpClientModule,
		ReactiveFormsModule,
		FormsModule,
		LayoutModule,
		ToastrModule.forRoot({
			timeOut: 5000,
			positionClass: 'toast-bottom-right',
			preventDuplicates: true,
		}),
		TranslateModule.forRoot(),

		// Material moment date module
		MatMomentDateModule,

		// Material
		MatMomentDateModule,
		MatButtonModule,
		MatIconModule,
		MatCheckboxModule,
		MatFormFieldModule,
		MatInputModule,
		MatDialogModule,
		MatRadioModule,
		A11yModule,
		CdkStepperModule,
		CdkTableModule,
		CdkTreeModule,
		DragDropModule,
		MatAutocompleteModule,
		MatBadgeModule,
		MatBottomSheetModule,
		MatButtonModule,
		MatButtonToggleModule,
		MatCardModule,
		MatCheckboxModule,
		MatChipsModule,
		MatStepperModule,
		MatDatepickerModule,
		MatDialogModule,
		MatDividerModule,
		MatExpansionModule,
		MatGridListModule,
		MatIconModule,
		MatInputModule,
		MatListModule,
		MatMenuModule,
		MatNativeDateModule,
		MatPaginatorModule,
		MatProgressBarModule,
		MatProgressSpinnerModule,
		MatRadioModule,
		MatRippleModule,
		MatSelectModule,
		MatSidenavModule,
		MatSliderModule,
		MatSlideToggleModule,
		MatSnackBarModule,
		MatSortModule,
		MatTableModule,
		MatTabsModule,
		MatToolbarModule,
		MatTooltipModule,
		MatTreeModule,
		PortalModule,
		ScrollingModule,

		// Fuse modules
		FuseModule.forRoot(fuseConfig),
		FuseProgressBarModule,
		FuseSharedModule,
		FuseSidebarModule,
		FuseThemeOptionsModule,

		// App modules
		LayoutModule,
		AppRoutingModule,
	],
	providers: [
		{
			provide: HTTP_INTERCEPTORS,
			useClass: TokenInterceptor,
			multi: true,
		},
		{
			provide: HTTP_INTERCEPTORS,
			useClass: ErrorInterceptor,
			multi: true,
		},
	],
	bootstrap: [
		AppComponent
	]
})
export class AppModule {
}
