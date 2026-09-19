class TimeLimitedCache {
    private cache: Map<number, { value: number; expiry: number }>;

    constructor() {
        this.cache = new Map();
    }

    set(key: number, value: number, duration: number): boolean {
        const now = Date.now();

        const existing = this.cache.get(key);

        const exists =
            existing !== undefined &&
            existing.expiry > now;

        this.cache.set(key, {
            value: value,
            expiry: now + duration
        });

        return exists;
    }

    get(key: number): number {
        const now = Date.now();

        const entry = this.cache.get(key);

        if (entry === undefined || entry.expiry <= now) {
            this.cache.delete(key);
            return -1;
        }

        return entry.value;
    }

    count(): number {
        const now = Date.now();
        let count = 0;

        for (const entry of this.cache.values()) {
            if (entry.expiry > now) {
                count++;
            }
        }

        return count;
    }
}