DROP TABLE IF EXISTS evaluation;
DROP TABLE IF EXISTS model1_prediction;
DROP TABLE IF EXISTS model2_prediction;

CREATE TABLE IF NOT EXISTS evaluation(
    model VARCHAR(255),
    RMSE FLOAT,
    R2 FLOAT,
    m_check15 FLOAT,
    m_check30 FLOAT
);

CREATE TABLE IF NOT EXISTS model1_prediction(
    label FLOAT,
    prediction FLOAT
);

CREATE TABLE IF NOT EXISTS model2_prediction(
    label FLOAT,
    prediction FLOAT
);
