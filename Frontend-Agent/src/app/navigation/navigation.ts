import { FuseNavigation } from '@fuse/types';

export const navigation: FuseNavigation[] = [
	{
		id				: 'menu',
		title			: 'Main menu',
		type			: 'group',
		children	: [
			{
				id			: 'home',
				title		: 'Home',
				type		: 'item',
				icon		: 'home',
				url			: '/pages/home',
			},
			{
				id			: 'create-new-vehicle',
				title		: 'Ad New Vehicle',
				type		: 'item',
				icon		: 'add_box',
				url			: '/pages/create-new-vehicle',
			},
			{
				id			: 'create-new-ad',
				title		: 'Create New Ad',
				type		: 'item',
				icon		: 'add_circle_outline',
				url			: '/pages/create-new-ad',
			},
			{
				id			: 'search-ad',
				title		: 'Search Ad',
				type		: 'item',
				icon		: 'search',
				url			: '/pages/search-ad',
			},
			{
				id			: 'register',
				title		: 'Register',
				type		: 'item',
				icon		: 'person',
				url			: '/pages/register',
			},
			{
				id			: 'statistic',
				title		: 'Statistic',
				type		: 'item',
				icon		: 'assessment',
				url			: '/pages/vehicle-statistic',
			},
			{
				id			: 'image',
				title		: 'Add Images',
				type		: 'item',
				icon		: 'image',
				url			: '/pages/add-images',
			},
		],
	},
];
