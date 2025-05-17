# file: data_generate_0507/repo.py

DB_CONFIG = {
    'host':     'localhost',
    'port':     5432,
    'database': 'xdra',            # your Liquibase‐created DB
    'user':     'xdra',       # the user you granted privileges to
    'password': 'Test!123', # or read from an env var
    'sslmode':  'prefer'
}