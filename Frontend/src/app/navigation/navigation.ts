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
				title		: 'Create new vehicle',
				type		: 'item',
				icon		: 'add_box',
				url			: '/pages/create-new-vehicle',
			},
			{
				id			: 'create-new-ad',
				title		: 'Create new ad',
				type		: 'item',
				icon		: 'add_circle_outline',
				url			: '/pages/create-new-ad',
			},
			{
				id			: 'search-ad',
				title		: 'Search ad',
				type		: 'item',
				icon		: 'search',
				url			: '/pages/search-ad',
			},
			{
				id			: 'request-to-rent',
				title		: 'Requests to rent',
				type		: 'item',
				icon		: 'account_balance',
				url			: '/pages/request-to-rent',
			},
			{
				id			: 'request-to-rent-details',
				title		: 'Requests to rent details',
				type		: 'item',
				icon		: 'description',
				url			: '/pages/request-to-rent-details',
			},
			{
				id			: 'messages',
				title		: 'Messages',
				type		: 'item',
				icon		: 'message',
				url			: '/pages/messages',
			},
			{
				id			: 'user-access',
				title		: 'User access',
				type		: 'item',
				icon		: 'user_group',
				url			: '/pages/user-access',
			},
			{
				id			: 'register',
				title		: 'Register',
				type		: 'item',
				icon		: 'person',
				url			: '/pages/register',
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
