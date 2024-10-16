package com.system.weather.model;

import java.util.List;


public record WeatherObject(Coord coord, List<Weather> weathers, String base, Main main, short visibility, Wind wind,
                            Clouds clouds, long dt, Sys sys, short timezone, short id, String name) {
}
