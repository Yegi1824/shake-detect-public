export interface ShakePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
