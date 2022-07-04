package com.aor.States.Observer;

import com.aor.Models.PowerUpModel.PowerUpModel;

public interface UserObserver {
    void notifyObserverBeginPowerUp(PowerUpModel powerUpModel);
    void notifyObserverEndPowerUp(PowerUpModel powerUpModel);
}
