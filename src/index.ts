import { registerPlugin } from '@capacitor/core';

import type { ShakePlugin } from './definitions';

const Shake = registerPlugin<ShakePlugin>('Shake');

export * from './definitions';
export { Shake };
