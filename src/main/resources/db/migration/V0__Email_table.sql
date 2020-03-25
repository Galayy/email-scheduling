CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE emails
(
    id            UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    email_address TEXT NOT NULL,
    last_sent_at  timestamp
);
