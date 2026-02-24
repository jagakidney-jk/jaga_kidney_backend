INSERT INTO users
(
    username,
    password_hash,
    role,
    status,
    created_at,
    updated_at
)
VALUES
(
    'patient1',
    '$2a$10$Dow1X0k1mKjvIh5j0uJ5OeYh5YFQn2R3hHqz9yKXcYwCzYJrWzYQG',
    'PATIENT',
    'ACTIVE',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
);

INSERT INTO users
(
    username,
    password_hash,
    role,
    status,
    created_at,
    updated_at
)
VALUES
(
    'staff1',
    '$2a$10$Dow1X0k1mKjvIh5j0uJ5OeYh5YFQn2R3hHqz9yKXcYwCzYJrWzYQG',
    'STAFF',
    'ACTIVE',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
);

INSERT INTO users
(
    username,
    password_hash,
    role,
    status,
    created_at,
    updated_at
)
VALUES
(
    'admin1',
    'password1',
    'ADMIN',
    'ACTIVE',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
);