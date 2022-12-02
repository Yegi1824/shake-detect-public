export interface ShakePlugin {
    start(): void;
    stop(): void;
    addListener(name: string, onSuccess: () => void): void;
}
