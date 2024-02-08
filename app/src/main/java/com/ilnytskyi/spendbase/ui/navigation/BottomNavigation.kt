package com.ilnytskyi.spendbase.ui.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ilnytskyi.spendbase.ui.theme.Neutral500


@Composable
fun BottomNavigation(rootNavController: NavController) {
    val items = listOf(
        BottomNavItem.Home, BottomNavItem.Transactions, BottomNavItem.MyCards, BottomNavItem.Account
    )

    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.White
    ) {
        val navBackStackEntry by rootNavController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            val selectedColor =
                if (currentRoute == item.route) MaterialTheme.colorScheme.onPrimary else Neutral500
            BottomNavigationItem(icon = {
                Icon(
                    modifier = Modifier.size(18.dp),
                    contentDescription = item.title,
                    painter = painterResource(id = item.icon),
                    tint = selectedColor
                )
            },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Center,
                        color = selectedColor
                    )
                },
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    rootNavController.navigate(item.route) {

                        rootNavController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }

}