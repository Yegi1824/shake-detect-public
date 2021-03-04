import { WebPlugin } from '@capacitor/core';

import type { ShakePlugin } from './definitions';

export class ShakeWeb extends WebPlugin implements ShakePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
