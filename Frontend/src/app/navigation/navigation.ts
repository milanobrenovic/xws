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
				id			: 'login',
				title		: 'Login',
				type		: 'item',
				icon		: 'lock',
				url			: '/pages/login',
			},
			{
				id			: 'register',
				title		: 'Register',
				type		: 'item',
				icon		: 'person',
				url			: '/pages/register',
			},
		],
	},
];
